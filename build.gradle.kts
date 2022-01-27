plugins {
    java
    distribution
    id("org.omegat.gradle") version "1.5.7"
}

version = "1.0.0"

omegat {
    version = "5.7.0"
    pluginClass = "net.libretraduko.omegat.CompactGlossaryLayout"
}

distributions {
    main {
        contents {
            from(tasks["jar"], "README.md", "COPYING")
        }
    }
}
