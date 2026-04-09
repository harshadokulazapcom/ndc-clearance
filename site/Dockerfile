# Site Dockerfile
# Must be built from project root context: docker build -f site/Dockerfile .

FROM docker.io/node:24 AS build
WORKDIR /app

# Copy schemas and content (required by build script)
COPY ndc_schemas ./ndc_schemas
COPY ndc_content ./ndc_content

# Build site
WORKDIR /app/site
COPY site/package.json site/package-lock.json ./
RUN npm install
COPY site .
RUN npm run build

FROM docker.io/nginx:alpine
COPY --from=build /app/site/dist /usr/share/nginx/html
COPY site/nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
