package com.gocamargo.vaboot.util

import org.jsoup.Jsoup
import org.jsoup.select.Elements

fun searchElementsFromPage(url: String, className: String): Elements=
        Jsoup.connect(url)
                .followRedirects(true)
                .get()
                .getElementsByClass(className)