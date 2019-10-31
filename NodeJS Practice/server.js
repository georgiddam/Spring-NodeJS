const express = require("express");
const app = express();
const bodyParser = require('body-parser');
const mongoose = require("mongoose");

require('dotenv/config')

// used to handle json data
app.use(bodyParser.json());


// Import Routes
const peopleRoute = require('./routes/people');

// Route
app.use('/people', peopleRoute);

// Connect to DB
mongoose.connect(process.env.DB_CONNECT, {
    useNewUrlParser: true,
    useUnifiedTopology: true
})
.then(() => console.log('DB Connected!'))
.catch(err => {
    console.log("Connection Error: ", err.message);
});

// Listen to a port
app.listen(8080);
