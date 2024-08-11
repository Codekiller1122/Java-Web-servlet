import java.awt.*;

import java.awt.image.*;

import javax.imageio.*;

import javax.servlet.http.*;

import java.io.*;

import java.util.*;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



/**

 * Servlet implementation class ClockServlet

 */

@WebServlet("/ClockServlet")

public class ClockServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;

       

   // create the image

    private BufferedImage createClockImage() {

        GregorianCalendar cal = new GregorianCalendar();



        BufferedImage img = new BufferedImage(400, 400, BufferedImage.TYPE_3BYTE_BGR);

        Graphics2D g = img.createGraphics();



        // white background

        g.setColor(Color.WHITE);

        g.fillRect(0, 0, 400, 400);



        // draw black circle around clock

        g.setColor(Color.BLACK);

        g.setStroke(new BasicStroke(5));

        g.drawOval(20, 20, 360, 360);



        // draw hour hand

        double hourRad = cal.get(Calendar.HOUR) * 2 * Math.PI / 12 - 0.5 * Math.PI;

        g.drawLine(200, 200, 200 + (int) (100 * Math.cos(hourRad)), 

                   200 + (int) (100 * Math.sin(hourRad)));



        // draw minute hand

        double minuteRad = cal.get(Calendar.MINUTE) * 2 * Math.PI / 60 - 0.5 * Math.PI;

        g.drawLine(200, 200, 200 + (int) (170 * Math.cos(minuteRad)), 

                   200 + (int) (170 * Math.sin(minuteRad)));

        return img;

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response)

          throws IOException {



        response.setContentType("image/png");



        OutputStream os = response.getOutputStream();

        ImageIO.write(createClockImage(), "PNG", os);  // write image as PNG (more)

    }



}