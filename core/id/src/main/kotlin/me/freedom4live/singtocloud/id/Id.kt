package me.freedom4live.singtocloud.id

import java.util.*
import kotlin.reflect.KClass

typealias Id = String

//Work around until https://youtrack.jetbrains.com/issue/KT-11968 is done
fun KClass<Id>.generate() = UUID.randomUUID().toString()
