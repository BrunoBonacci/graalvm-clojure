(defproject sample-project "0.1.0-SNAPSHOT"

  :dependencies [[org.clojure/clojure "1.9.0"]
                 [de.ubercode.clostache/clostache "1.4.0"]
                 ]

  :main simple.main

  :uberjar-name "simple-main.jar"

  :profiles {:uberjar {:aot :all}
             :dev {:plugins [[lein-shell "0.5.0"]]}}

  :aliases
  {"native"
   ["shell"
    "native-image" "--report-unsupported-elements-at-runtime" "--no-server"
    "--initialize-at-build-time"
    "-jar" "./target/${:uberjar-name:-${:name}-${:version}-standalone.jar}"
    "-H:ReflectionConfigurationFiles=reflect-config.json"
    "-H:+AllowIncompleteClasspath"
    "-H:Name=./target/${:name}"]

   "run-native" ["shell" "./target/${:name}"]})
