package com.app.architectureSample.common.dependencyInjection.qualifier

import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IODispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class MainDispatcher