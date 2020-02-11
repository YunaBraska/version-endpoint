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
    <version>0.2.0</version>
</dependency>
```

### Configuration
```yaml
management:
  endpoint:
    version:
      path: /internal/version
```

```json
{
    "projectName": "version-endpoint",
    "projectGroup": "berlin.yuna",
    "projectArtifact": "version-endpoint",
    "projectVersion": "0.2.0",
    "git": {
        "tags": "",
        "build.version": "0.2.0",
        "closest.tag.commit.count": "20",
        "commit.user.name": "Yuna Morgenstern",
        "commit.id.abbrev": "a6729de",
        "branch": "testbranch",
        "build.host": "Cr15t4lF1r3",
        "commit.id.describe-short": "0.1.0-1-dirty",
        "total.commit.count": "8",
        "commit.id.describe": "0.1.0-1-ga6729de-dirty",
        "build.user.email": "git@example.com",
        "commit.id": "a6729de1f723aa3ddc84635a7cf9769dea489e17",
        "commit.message.short": "my cool commit message",
        "commit.user.email": "git@example.com",
        "closest.tag.name": "0.2.0",
        "local.branch.ahead": "0",
        "build.time": "1988-08-20T20:12:58+0100",
        "commit.time": "1988-08-20T18:22:17+0100",
        "local.branch.behind": "0",
        "build.user.name": "",
        "dirty": "true",
        "commit.message.full": "my cool commit message",
        "remote.origin.url": "https://github.com/YunaBraska/version-endpoint.git"
    }
}
```

### Troubleshooting
* BuildProperties are not initialized: just the following command 
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

### TODO
[ ] path to custom properties file

![logo](logo.png "logo")