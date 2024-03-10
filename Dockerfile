FROM clojure

WORKDIR /home/app/

RUN apt update && apt install nodejs npm -y

CMD ["bash"]