// Schema for the database, showing how people DB table will look like
const mongoose = require('mongoose');

const personSchema = mongoose.Schema({
    name: {
        type: String,
        required: true
    },
    age: {
        type: Number,
        required: true
    }
});

module.exports = mongoose.model('People', personSchema)
