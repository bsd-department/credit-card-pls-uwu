package org.uwu

import com.sksamuel.scrimage.nio.AnimatedGif
import com.sksamuel.scrimage.nio.AnimatedGifReader
import com.sksamuel.scrimage.nio.ImageSource
import java.io.IOException

object GifLoader {
    @Throws(IOException::class)
    fun fromJAR(path: String): AnimatedGif = this.javaClass.getResourceAsStream(path)
        .let(ImageSource::of)
        .let(AnimatedGifReader::read)
}