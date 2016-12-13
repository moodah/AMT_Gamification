# NodeJS / MochaJS testing image
FROM node:latest
MAINTAINER https://github.com/moodah/AMT_Gamification

# Copy local files
# build context is: ../../
ADD package.json ./
ADD mocha/* test/
WORKDIR .

# Configure the image
RUN npm install

# Run the tests
CMD ["npm", "test"]