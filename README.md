# version-endpoint
*Creates a version endpoint with git properties like SHA etc.*

![Build][Build-shield] 
[![Maintainable][Maintainable-image]][Maintainable-Url]
![Coverage][Coverage-shield]
![Central][Central-shield] 
![Tag][Tag-shield]
![Issues][Issues-shield] 
![Commit][Commit-shield] 
![Size][Size-shield] 
![Dependency][Dependency-shield]
![License][License-shield]
![Label][Label-shield]

[License-Url]: https://www.apache.org/licenses/LICENSE-2.0
[Build-Status-Url]: https://travis-ci.org/YunaBraska/version-endpoint
[Build-Status-Image]: https://travis-ci.org/YunaBraska/version-endpoint.svg?branch=master
[Coverage-Url]: https://codecov.io/gh/YunaBraska/version-endpoint?branch=master
[Coverage-image]: https://img.shields.io/codecov/c/github/YunaBraska/config-metadata-generator?style=flat-square
[Maintainable-Url]: https://codeclimate.com/github/YunaBraska/config-metadata-generator/maintainability
[Maintainable-image]: https://img.shields.io/codeclimate/maintainability/YunaBraska/config-metadata-generator?style=flat-square
[Javadoc-url]: http://javadoc.io/doc/berlin.yuna/version-endpoint
[Javadoc-image]: http://javadoc.io/badge/berlin.yuna/version-endpoint.svg
[Gitter-Url]: https://gitter.im/nats-streaming-server-embedded/Lobby
[Gitter-image]: https://img.shields.io/badge/gitter-join%20chat%20%E2%86%92-brightgreen.svg

[Dependency-shield]: https://img.shields.io/librariesio/github/YunaBraska/version-endpoint?style=flat-square
[Tag-shield]: https://img.shields.io/github/v/tag/YunaBraska/version-endpoint?style=flat-square
[Central-shield]: https://img.shields.io/maven-central/v/berlin.yuna/version-endpoint?style=flat-square
[Size-shield]: https://img.shields.io/github/repo-size/YunaBraska/version-endpoint?style=flat-square
[Issues-shield]: https://img.shields.io/github/issues/YunaBraska/version-endpoint?style=flat-square
[License-shield]: https://img.shields.io/github/license/YunaBraska/version-endpoint?style=flat-square
[Commit-shield]: https://img.shields.io/github/last-commit/YunaBraska/version-endpoint?style=flat-square
[Label-shield]: https://img.shields.io/badge/Yuna-QueenInside-blueviolet?style=flat-square
[Build-shield]: https://img.shields.io/travis/YunaBraska/version-endpoint/master?style=flat-square
[Coverage-shield]: https://img.shields.io/codecov/c/github/YunaBraska/version-endpoint?style=flat-square

### How to use it
```xml
<dependency>
    <groupId>berlin.yuna</groupId>
    <artifactId>version-endpoint</artifactId>
    <version>0.0.2</version>
</dependency>
```

### Troubleshooting
* Run the following command if the spring boot BuildProperties are not initialized
```shell script
mvn clean compile
```

* Add spring-boot-maven-plugin if the solution above did't help 
```xml
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <version>${spring-boot.version}</version>
    <executions>
        <execution>
            <phase>compile</phase>
            <id>build-info</id>
            <goals>
                <goal>build-info</goal>
            </goals>
        </execution>
    </executions>
</plugin>                
```

![logo](logo.png "logo")