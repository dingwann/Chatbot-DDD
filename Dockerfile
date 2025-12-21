# 使用 OpenJDK 17 基础镜像
FROM openjdk:17-jdk-slim

# 设置工作目录
WORKDIR /chatbot

# 复制 jar 包到容器中
COPY /chatbot-ddd-interfaces/target/chatbot-ddd.jar app.jar

# 设置时区为上海
ENV TZ=Asia/Shanghai

# 开放端口 8080
EXPOSE 8080

# 启动应用
ENTRYPOINT ["java", "-jar", "app.jar"]