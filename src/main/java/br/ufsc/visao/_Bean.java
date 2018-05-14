package br.ufsc.visao;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

public abstract class _Bean
{
    public _Bean() {

    }

    String displayedLogo = "";

    public String msg(String key)
    {
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
        String message = bundle.getString(key);
        return message;
    }

    public void uploadNewLogo(FileUploadEvent event) throws IOException
    {
        UploadedFile uploadedLogo = event.getFile();

        if (uploadedLogo != null)
        {
            String uploadedLogoFileName = System.currentTimeMillis()+"_"+uploadedLogo.getFileName().toLowerCase().replace(" ","_");

            if (!uploadedLogoFileName.endsWith(".png") &&
                    !uploadedLogoFileName.endsWith(".jpg") &&
                    !uploadedLogoFileName.endsWith(".gif"))
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro","A logomarca deve ser uma imagem do tipo PNG, JPG ou GIF"));
                return;
            }

            String absoluteWebPath = getExternalContext().getRealPath("/");
            String uploadedLogoPath = absoluteWebPath+"/upload/"+uploadedLogoFileName;

            try
            {
                System.out.println(uploadedLogoPath);
                uploadedLogo.write(uploadedLogoPath);
                displayedLogo = uploadedLogoFileName;

                this.scale(uploadedLogoPath, 300, 300, uploadedLogoPath);

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Imagem atualizada com sucesso",null));
            }
            catch (Exception e)
            {
                e.printStackTrace();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro","Erro ao gravar a imagem no servidor"));
            }
        }
    }

    public static void scale(String src, int width, int height, String dest)
            throws IOException {
        BufferedImage bsrc = ImageIO.read(new File(src));

        int h = bsrc.getHeight();
        int w = bsrc.getWidth();

        int maior = h;
        int padding = 0;
        int padding2 = 0;
        if(w > maior)
        {
            maior = w;
            //H
            padding = maior - h;
        }
        else
        {
            //W
            padding2 = maior - w;
        }

        System.out.println(padding);
        System.out.println(padding2);

        BufferedImage newImage = new BufferedImage(bsrc.getWidth()+padding2, bsrc.getHeight()+padding, bsrc.getType());

        Graphics g1 = newImage.getGraphics();

        g1.setColor(Color.white);
        g1.fillRect(0,0,bsrc.getWidth()+padding2,bsrc.getHeight()+padding);
        if(padding==0)
        {
            g1.drawImage(bsrc, newImage.getWidth()/2-bsrc.getWidth()/2, 0, null);
        }
        else
        {
            g1.drawImage(bsrc, 0, newImage.getHeight()/2-bsrc.getHeight()/2, null);
        }
        g1.dispose();

//		   bsrc = Scalr.resize(bsrc, 60);
//		   int padding = 0;
//
//		   BufferedImage img2 = new BufferedImage(newImage.getHeight(),newImage.getWidth(), BufferedImage.TYPE_INT_ARGB);
//		   Graphics2D g2 = img2.createGraphics();
//		   g2.setPaint(new Color(0,0,0,0));
//		   g2.fillRect(0, 0, newImage.getHeight(), newImage.getWidth());
//		   g2.drawImage(newImage, newImage.getHeight(),newImage.getWidth(), null);

        BufferedImage bdest = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bdest.createGraphics();
        AffineTransform at = AffineTransform.getScaleInstance((double)width/newImage.getWidth(),(double)height/newImage.getHeight());
        g.drawRenderedImage(newImage,at);
        ImageIO.write(bdest,"JPG",new File(dest));
    }

    public Object getJsfParam(String param){
        return getHttpServletRequest().getAttribute(param);
    }

    public HttpServletRequest getHttpServletRequest(){
        return (HttpServletRequest)getExternalContext().getRequest();
    }

    public HttpServletResponse getHttpServletResponse() {
        return (HttpServletResponse)getExternalContext().getResponse();
    }

    public HttpSession getHttpSession(){
        return getHttpServletRequest().getSession();
    }

    public ExternalContext getExternalContext(){
        return getFacesContext().getExternalContext();
    }

    public ServletContext getServletContext(){
        return (ServletContext)getExternalContext().getContext();
    }

    public String getFileSeparator(){
        return System.getProperty("file.separator");
    }

    public FacesContext getFacesContext(){
        return FacesContext.getCurrentInstance();
    }
}
