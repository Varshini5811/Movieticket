import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ReadImage
{
    public static void main( String[] args )
    {
		
		String dir = System.getProperty("dir");
		Runtime rt = Runtime.getRuntime();
		Process proc = rt.exec("cmd.exe /C dir " + dir);}
 	 	int result = proc.waitFor();
		if (result != 0) {
		  System.out.println("process error: " + result);
		}
		InputStream in = (result == 0) ? proc.getInputStream() :
										 proc.getErrorStream();
		int c;
		while ((c = in.read()) != -1) {
		  System.out.print((char) c);
		}
		
		
		
		try {
			  FileInputStream fis =
				  new FileInputStream(System.getenv("APPDATA") + args[0]);
					} catch (FileNotFoundException e) {
					  // Log the exception
					  throw new IOException("Unable to retrieve file", e);
					}
		
		
		System.out.println("Problem executing cmdi - java.lang.ProcessBuilder(java.lang.String[]) Test Case");
    	Image image = null;
        try {
            URL url = new URL("http://www.mkyong.com/image/mypic.jpg?f=111");
            image = ImageIO.read(url);
        } catch (IOException e) {
        	e.printStackTrace();
        }

        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        JLabel label = new JLabel(new ImageIcon(image));
        frame.add(label);
        frame.setVisible(true);
    }
	
	
}


public class ForwardServlet extends HttpServlet 
{
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String query = request.getQueryString();
    if (query.contains("fwd")) 
    {
      String fwd = request.getParameter("fwd");
      try 
      {
      request.getRequestDispatcher(fwd).forward(request, response);
      } 
      catch (ServletException e) 
      {
        e.printStackTrace();
      }
    }
  }
}