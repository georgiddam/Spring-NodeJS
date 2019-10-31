const express = require("express");
const mongoose = require("mongoose")
require('dotenv/config')
const app = express();

// Create route handler
app.get('/' , (req, res) => {
    res.send("Hello world")
});

app.get('/people' , (req, res) => {
    res.send("Data with people")
});


// Connect to DB
mongoose.connect(process.env.DB_CONNECT, {
    useNewUrlParser: true },
    () => {
    console.log("Connected to database")
});

// Listen to a port
app.listen(8080);
