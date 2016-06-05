import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageManipulation {

	public static void main(String[] args) throws IOException {
		int width,height;
		File f = new File("ABC"); //*****Enter the input file location.(Preferably absolute)
		BufferedImage img = null;
		try{
			img = ImageIO.read(f);
			System.out.println("Finished reading");
			
		}catch(IOException e){
			System.out.println(e);
		}
		width = img.getWidth();
		height = img.getHeight();
		
		for(int i=1;i<height;i++)
		{
			for(int j=1;j<width;j++)
			{
				int p = img.getRGB(j,i);
				int a = (p>>24)&0xff; //Right shift because we need the left most 8 bits of the 32 bit integer.
				int r = (p>>16)&0xff;
				int g = (p>>8)&0xff;
				int b = (p)&0xff;
				int x = (r+g+b)/3; //Used for finding the corresponding pixel in black and white
				p = (a<<24) | (r<<16) | (0<<8) | 0; //Left shift to store the values in their corresponding positions.
				img.setRGB(j, i, p);
			}
		}
		try{
			f = new File("ABC"); //*****Enter the output file location.(Preferably absolute)
			ImageIO.write(img, "jpg", f);
			System.out.println("Finished writing");
		}catch(IOException e)
		{
			System.out.println(e);
		}
	}

}
