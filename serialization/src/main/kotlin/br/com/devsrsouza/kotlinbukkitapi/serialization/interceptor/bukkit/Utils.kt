package br.com.devsrsouza.kotlinbukkitapi.serialization.interceptor.bukkit

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.descriptors.SerialDescriptor

@ExperimentalSerializationApi
internal inline fun <reified A : Annotation> SerialDescriptor.findElementAnnotation(
    elementIndex: Int
): A? {
    return getElementAnnotations(elementIndex).find { it is A } as A?
}

@ExperimentalSerializationApi
internal inline fun <reified A : Annotation> SerialDescriptor.findEntityAnnotation(): A? {
    return annotations.find { it is A } as A?
}