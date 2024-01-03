package com.github.codeideal.v2explugin.koin

import kotlin.random.Random

/**
 * @program: Plugin
 *
 * @description: koin app module
 *
 * @author: kangyang
 *
 * @create: 2023/12/31 01:17
 **/
class V2exService{
    fun getRandomInt(until: Int = Int.MIN_VALUE) :Int= Random.nextInt(until)
}