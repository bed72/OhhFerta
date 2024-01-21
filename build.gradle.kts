@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.detekt) apply true
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.library.android) apply false
    alias(libs.plugins.application.android) apply false
}

true