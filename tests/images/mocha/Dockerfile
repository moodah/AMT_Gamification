# NodeJS / MochaJS testing image
FROM node:latest
MAINTAINER https://github.com/moodah/AMT_Gamification

# Copy local files
ADD . .
WORKDIR .

# Configure the image
RUN npm install

# Run the tests
CMD ["npm", "test"]