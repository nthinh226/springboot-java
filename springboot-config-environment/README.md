Cách để config các môi trường dev, test, pre-release, product...

## use profile
application-{profile}.properties

application-{profile}.yaml

profile = dev, pro, dev, rel

Active profile:
- sử dụng `spring.profiles.active` trong `application`

- run cli with file jar:

```bash
java -jar .\springboot-config-environment-0.0.1-SNAPSHOT.jar -spring.profiles.active=pro
```