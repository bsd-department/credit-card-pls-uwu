package org.uwu

import com.formdev.flatlaf.FlatDarkLaf
import com.sksamuel.scrimage.ScaleMethod
import com.sksamuel.scrimage.nio.StreamingGifWriter
import java.awt.*
import java.awt.image.BufferedImage
import java.io.File
import javax.swing.*

fun main(args: Array<String>) {
    FlatDarkLaf.setup()

    JFrame("Totally not malware").apply {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        layout = GridBagLayout()
        val imageLabel = JLabel()
        add(imageLabel, GridBagConstraints().apply {
            gridx = 0
            gridy = 0
            gridheight = 5
        })
        add(JLabel("""<html><center>H-hi there...</center>
            |<p style="margin-left: 10px; margin-right: 10px; margin-bottom: 10px">
            |Do you th-think I could have your credit<br />
            |card information, p-please?
            |</p></html>""".trimMargin()).apply {
            putClientProperty("FlatLaf.styleClass", "h2")
        }, GridBagConstraints().apply {
            gridx = 1
            gridy = 0
            gridheight = 1
            gridwidth = 2
        })

        val labelInsets = Insets(10, 10, 0, 10)
        val inputInsets = Insets(10, 0, 0, 0)
        add(JLabel("Card Number:").apply {
            putClientProperty("FlatLaf.styleClass", "h2")
        }, GridBagConstraints().apply {
            gridx = 1
            gridy = 1
            insets = labelInsets
        })

        val cardNumber = JTextField()
        cardNumber.putClientProperty("FlatLaf.styleClass", "h2.regular")
        add(cardNumber, GridBagConstraints().apply {
            gridx = 2
            gridy = 1
            fill = GridBagConstraints.HORIZONTAL
            insets = inputInsets
        })

        add(JLabel("Expiry date:").apply {
            putClientProperty("FlatLaf.styleClass", "h2")
        }, GridBagConstraints().apply {
            gridx = 1
            gridy = 2
            insets = labelInsets
        })

        val expiryDate = JTextField()
        expiryDate.putClientProperty("FlatLaf.styleClass", "h2.regular")
        add(expiryDate, GridBagConstraints().apply {
            gridx = 2
            gridy = 2
            fill = GridBagConstraints.HORIZONTAL
            insets = inputInsets
        })

        add(JLabel("Security code:").apply {
            putClientProperty("FlatLaf.styleClass", "h2")
        }, GridBagConstraints().apply {
            gridx = 1
            gridy = 3
            insets = labelInsets
        })

        val securityCode = JTextField()
        securityCode.putClientProperty("FlatLaf.styleClass", "h2.regular")
        add(securityCode, GridBagConstraints().apply {
            gridx = 2
            gridy = 3
            fill = GridBagConstraints.HORIZONTAL
            insets = inputInsets
        })

        val thanksButton = JButton("Th-thanks")
        thanksButton.putClientProperty("FlatLaf.styleClass", "h2")
        add(thanksButton, GridBagConstraints().apply {
            gridx = 1
            gridy = 4
            gridwidth = 2
            anchor = GridBagConstraints.PAGE_START
            insets = Insets(15, 0, 5, 0)
        })
        pack()
        val gif = GifLoader.fromJAR("/img/tsukasa.gif")
        val h = contentPane.height
        val tmp = File.createTempFile("tsukasa", ".gif")
        val stream = StreamingGifWriter().prepareStream(tmp, BufferedImage.TYPE_INT_ARGB)
        tmp.deleteOnExit()
        for(i in gif.frames.indices) {
            val delay = gif.getDelay(i)
            val frame = gif.getFrame(i).scaleToHeight(h, ScaleMethod.Progressive)
            val dispose = gif.getDisposeMethod(i)
            stream.writeFrame(frame, delay, dispose)
        }
        stream.close()
        imageLabel.icon = ImageIcon(tmp.toURI().toURL())
        pack()
        isLocationByPlatform = true
        isVisible = true
        SwingUtilities.invokeLater {
            isResizable = false
        }
    }

}