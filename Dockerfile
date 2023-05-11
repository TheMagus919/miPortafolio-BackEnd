
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM amazoncorreto:17

COPY target/miportafolio-0.0.1-SNAPSHOT.jar miportafolio-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/miportafolio-0.0.1-SNAPSHOT.jar"]