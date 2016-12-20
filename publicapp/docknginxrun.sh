docker run --net=host -p 80:80 --name publicvacancy \
-v /home/bob/IdeaProjects/workflow/publicapp/statichtml:/usr/share/nginx/html:ro \
-v conf:/etc/nginx:ro  \
-d nginx