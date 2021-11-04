# Accelerator Log

## Options
```json
{
  "projectName" : "tanzu-java-web-app",
  "repositoryPrefix" : "harbor.apps.cf.tanzutime.com/apps"
}
```
## Log
```
┏ engine (Chain)
┃  Info Running Chain(Combo, UniquePath)
┃ ┏ engine.transformations[0] (Combo)
┃ ┃  Info Combo running as Chain(Merge(merge), UniquePath(UseLast))
┃ ┃ engine.transformations[0].merge (Chain)
┃ ┃  Info Running Chain(Merge, UniquePath)
┃ ┃ ┏ engine.transformations[0].merge.transformations[0] (Merge)
┃ ┃ ┃  Info Running Merge(Combo, Combo, Combo)
┃ ┃ ┃ ┏ engine.transformations[0].merge.transformations[0].sources[0] (Combo)
┃ ┃ ┃ ┃  Info Combo running as Chain(Include, Exclude)
┃ ┃ ┃ ┃ engine.transformations[0].merge.transformations[0].sources[0].<combo> (Chain)
┃ ┃ ┃ ┃  Info Running Chain(Include, Exclude)
┃ ┃ ┃ ┃ ┏ engine.transformations[0].merge.transformations[0].sources[0].<combo>.transformations[0] (Include)
┃ ┃ ┃ ┃ ┃  Info Will include [**/*]
┃ ┃ ┃ ┃ ┃ Debug .gitignore matched [**/*] -> included
┃ ┃ ┃ ┃ ┃ Debug .mvn/wrapper/MavenWrapperDownloader.java matched [**/*] -> included
┃ ┃ ┃ ┃ ┃ Debug .mvn/wrapper/maven-wrapper.jar matched [**/*] -> included
┃ ┃ ┃ ┃ ┃ Debug .mvn/wrapper/maven-wrapper.properties matched [**/*] -> included
┃ ┃ ┃ ┃ ┃ Debug .tanzu/tanzu_tilt_extensions.py matched [**/*] -> included
┃ ┃ ┃ ┃ ┃ Debug .tanzu/wait.sh matched [**/*] -> included
┃ ┃ ┃ ┃ ┃ Debug LICENSE matched [**/*] -> included
┃ ┃ ┃ ┃ ┃ Debug README.md matched [**/*] -> included
┃ ┃ ┃ ┃ ┃ Debug Tiltfile matched [**/*] -> included
┃ ┃ ┃ ┃ ┃ Debug config/workload.yaml matched [**/*] -> included
┃ ┃ ┃ ┃ ┃ Debug mvnw matched [**/*] -> included
┃ ┃ ┃ ┃ ┃ Debug mvnw.cmd matched [**/*] -> included
┃ ┃ ┃ ┃ ┃ Debug pom.xml matched [**/*] -> included
┃ ┃ ┃ ┃ ┃ Debug src/main/java/com/example/springboot/Application.java matched [**/*] -> included
┃ ┃ ┃ ┃ ┃ Debug src/main/java/com/example/springboot/HelloController.java matched [**/*] -> included
┃ ┃ ┃ ┃ ┃ Debug src/main/resources/application.yml matched [**/*] -> included
┃ ┃ ┃ ┃ ┗ Debug src/test/java/com/example/springboot/HelloControllerTest.java matched [**/*] -> included
┃ ┃ ┃ ┃ ┏ engine.transformations[0].merge.transformations[0].sources[0].<combo>.transformations[1] (Exclude)
┃ ┃ ┃ ┃ ┃  Info Will exclude [config/*.yaml, Tiltfile, README.md]
┃ ┃ ┃ ┃ ┃ Debug .gitignore didn't match [config/*.yaml, Tiltfile, README.md] -> included
┃ ┃ ┃ ┃ ┃ Debug .mvn/wrapper/MavenWrapperDownloader.java didn't match [config/*.yaml, Tiltfile, README.md] -> included
┃ ┃ ┃ ┃ ┃ Debug .mvn/wrapper/maven-wrapper.jar didn't match [config/*.yaml, Tiltfile, README.md] -> included
┃ ┃ ┃ ┃ ┃ Debug .mvn/wrapper/maven-wrapper.properties didn't match [config/*.yaml, Tiltfile, README.md] -> included
┃ ┃ ┃ ┃ ┃ Debug .tanzu/tanzu_tilt_extensions.py didn't match [config/*.yaml, Tiltfile, README.md] -> included
┃ ┃ ┃ ┃ ┃ Debug .tanzu/wait.sh didn't match [config/*.yaml, Tiltfile, README.md] -> included
┃ ┃ ┃ ┃ ┃ Debug LICENSE didn't match [config/*.yaml, Tiltfile, README.md] -> included
┃ ┃ ┃ ┃ ┃ Debug README.md matched [config/*.yaml, Tiltfile, README.md] -> excluded
┃ ┃ ┃ ┃ ┃ Debug Tiltfile matched [config/*.yaml, Tiltfile, README.md] -> excluded
┃ ┃ ┃ ┃ ┃ Debug config/workload.yaml matched [config/*.yaml, Tiltfile, README.md] -> excluded
┃ ┃ ┃ ┃ ┃ Debug mvnw didn't match [config/*.yaml, Tiltfile, README.md] -> included
┃ ┃ ┃ ┃ ┃ Debug mvnw.cmd didn't match [config/*.yaml, Tiltfile, README.md] -> included
┃ ┃ ┃ ┃ ┃ Debug pom.xml didn't match [config/*.yaml, Tiltfile, README.md] -> included
┃ ┃ ┃ ┃ ┃ Debug src/main/java/com/example/springboot/Application.java didn't match [config/*.yaml, Tiltfile, README.md] -> included
┃ ┃ ┃ ┃ ┃ Debug src/main/java/com/example/springboot/HelloController.java didn't match [config/*.yaml, Tiltfile, README.md] -> included
┃ ┃ ┃ ┃ ┃ Debug src/main/resources/application.yml didn't match [config/*.yaml, Tiltfile, README.md] -> included
┃ ┃ ┃ ┗ ┗ Debug src/test/java/com/example/springboot/HelloControllerTest.java didn't match [config/*.yaml, Tiltfile, README.md] -> included
┃ ┃ ┃ ┏ engine.transformations[0].merge.transformations[0].sources[1] (Combo)
┃ ┃ ┃ ┃  Info Combo running as Chain(Include, Chain(chain))
┃ ┃ ┃ ┃ engine.transformations[0].merge.transformations[0].sources[1].<combo> (Chain)
┃ ┃ ┃ ┃  Info Running Chain(Include, Chain)
┃ ┃ ┃ ┃ ┏ engine.transformations[0].merge.transformations[0].sources[1].<combo>.transformations[0] (Include)
┃ ┃ ┃ ┃ ┃  Info Will include [config/*.yaml, Tiltfile]
┃ ┃ ┃ ┃ ┃ Debug .gitignore didn't match [config/*.yaml, Tiltfile] -> excluded
┃ ┃ ┃ ┃ ┃ Debug .mvn/wrapper/MavenWrapperDownloader.java didn't match [config/*.yaml, Tiltfile] -> excluded
┃ ┃ ┃ ┃ ┃ Debug .mvn/wrapper/maven-wrapper.jar didn't match [config/*.yaml, Tiltfile] -> excluded
┃ ┃ ┃ ┃ ┃ Debug .mvn/wrapper/maven-wrapper.properties didn't match [config/*.yaml, Tiltfile] -> excluded
┃ ┃ ┃ ┃ ┃ Debug .tanzu/tanzu_tilt_extensions.py didn't match [config/*.yaml, Tiltfile] -> excluded
┃ ┃ ┃ ┃ ┃ Debug .tanzu/wait.sh didn't match [config/*.yaml, Tiltfile] -> excluded
┃ ┃ ┃ ┃ ┃ Debug LICENSE didn't match [config/*.yaml, Tiltfile] -> excluded
┃ ┃ ┃ ┃ ┃ Debug README.md didn't match [config/*.yaml, Tiltfile] -> excluded
┃ ┃ ┃ ┃ ┃ Debug Tiltfile matched [config/*.yaml, Tiltfile] -> included
┃ ┃ ┃ ┃ ┃ Debug config/workload.yaml matched [config/*.yaml, Tiltfile] -> included
┃ ┃ ┃ ┃ ┃ Debug mvnw didn't match [config/*.yaml, Tiltfile] -> excluded
┃ ┃ ┃ ┃ ┃ Debug mvnw.cmd didn't match [config/*.yaml, Tiltfile] -> excluded
┃ ┃ ┃ ┃ ┃ Debug pom.xml didn't match [config/*.yaml, Tiltfile] -> excluded
┃ ┃ ┃ ┃ ┃ Debug src/main/java/com/example/springboot/Application.java didn't match [config/*.yaml, Tiltfile] -> excluded
┃ ┃ ┃ ┃ ┃ Debug src/main/java/com/example/springboot/HelloController.java didn't match [config/*.yaml, Tiltfile] -> excluded
┃ ┃ ┃ ┃ ┃ Debug src/main/resources/application.yml didn't match [config/*.yaml, Tiltfile] -> excluded
┃ ┃ ┃ ┃ ┗ Debug src/test/java/com/example/springboot/HelloControllerTest.java didn't match [config/*.yaml, Tiltfile] -> excluded
┃ ┃ ┃ ┃ ┏ engine.transformations[0].merge.transformations[0].sources[1].<combo>.transformations[1] (Chain)
┃ ┃ ┃ ┃ ┃  Info Running Chain(ReplaceText, ReplaceText)
┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].merge.transformations[0].sources[1].<combo>.transformations[1].transformations[0] (ReplaceText)
┃ ┃ ┃ ┃ ┃ ┗  Info Will replace [sample-app-java->tanzu-java-web-app]
┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].merge.transformations[0].sources[1].<combo>.transformations[1].transformations[1] (ReplaceText)
┃ ┃ ┃ ┗ ┗ ┗  Info Will replace [your-registry.io/project->harbor.apps.cf.tanzu...(truncated)]
┃ ┃ ┃ ┏ engine.transformations[0].merge.transformations[0].sources[2] (Combo)
┃ ┃ ┃ ┃  Info Combo running as Chain(Include, Chain(chain))
┃ ┃ ┃ ┃ engine.transformations[0].merge.transformations[0].sources[2].<combo> (Chain)
┃ ┃ ┃ ┃  Info Running Chain(Include, Chain)
┃ ┃ ┃ ┃ ┏ engine.transformations[0].merge.transformations[0].sources[2].<combo>.transformations[0] (Include)
┃ ┃ ┃ ┃ ┃  Info Will include [README.md]
┃ ┃ ┃ ┃ ┃ Debug .gitignore didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ Debug .mvn/wrapper/MavenWrapperDownloader.java didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ Debug .mvn/wrapper/maven-wrapper.jar didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ Debug .mvn/wrapper/maven-wrapper.properties didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ Debug .tanzu/tanzu_tilt_extensions.py didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ Debug .tanzu/wait.sh didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ Debug LICENSE didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ Debug README.md matched [README.md] -> included
┃ ┃ ┃ ┃ ┃ Debug Tiltfile didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ Debug config/workload.yaml didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ Debug mvnw didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ Debug mvnw.cmd didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ Debug pom.xml didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ Debug src/main/java/com/example/springboot/Application.java didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ Debug src/main/java/com/example/springboot/HelloController.java didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ Debug src/main/resources/application.yml didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┗ Debug src/test/java/com/example/springboot/HelloControllerTest.java didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┏ engine.transformations[0].merge.transformations[0].sources[2].<combo>.transformations[1] (Chain)
┃ ┃ ┃ ┃ ┃  Info Running Chain(ReplaceText)
┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].merge.transformations[0].sources[2].<combo>.transformations[1].transformations[0] (ReplaceText)
┃ ┃ ┗ ┗ ┗ ┗  Info Will replace [tanzu-java-web-app->tanzu-java-web-app]
┃ ┗ ╺ engine.transformations[0].merge.transformations[1] (UniquePath)
┗ ╺ engine.transformations[1] (UniquePath)
```
