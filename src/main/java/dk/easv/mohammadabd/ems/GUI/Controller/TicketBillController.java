package dk.easv.mohammadabd.ems.GUI.Controller;

import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import dk.easv.mohammadabd.ems.BE.Ticket;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public class TicketBillController {
    @FXML private Label ticketNameLabel;
    @FXML private Label ticketType;
    @FXML private Label ticketNotes;
    @FXML private Label ticketDateTime;
    @FXML private Label ticketLocation;
    @FXML private Label ticketLocationGuidance;
    @FXML private ImageView ticketQrCode;



    public static Image generateQrCode(String text) {
        int width = 220;
        int height = 220;

        try {
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

            BitMatrix bitMatrix = new MultiFormatWriter()
                    .encode(text, BarcodeFormat.QR_CODE, width, height, hints);

            // Create a transparent BufferedImage
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

            // Transparent background + black pixels
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    image.setRGB(x, y, bitMatrix.get(x, y) ? Color.BLACK.getRGB() : 0x00FFFFFF); // ARGB for transparent white
                }
            }

            // Convert BufferedImage to JavaFX Image
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(image, "png", os);
            ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
            return new Image(is);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public void updateTicket(Ticket ticket) {
        ticketNameLabel.setText(ticket.getEventName());
        ticketNotes.setText(ticket.getNotes());
        ticketLocation.setText(ticket.getLocation());
        ticketLocationGuidance.setText(ticket.getLocationGuidance());
        ticketDateTime.setText(ticket.getStart_time() + " - " + ticket.getEnd_time());
        ticketLocationGuidance.setText(ticket.getLocationGuidance());
        if(ticket.getQrcode() != null) {
            ticketQrCode.setImage(generateQrCode(ticket.getQrcode()));
        }else {
            ticketQrCode.setImage(generateQrCode("this is a Random Generated QR code Picture"));
        }

        ticketType.setText(ticket.getType());
    }
}
