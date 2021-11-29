FROM java:8
ADD /out/artifacts/lab_1_jar/lab_1.jar lab_1.jar
ENTRYPOINT ["java","-jar","lab_1.jar"]