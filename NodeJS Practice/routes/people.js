const express = require("express");

const router = express.Router();
const Person = require('../models/Person')
// Create route handler
router.get('/' , (req, res) => {
    console.log(Person.find());
    Person.find()
    .then(data => {
        res.json(data);
    })
    .catch(err => {
        res.json({message:err});
    });
});

router.post('/', (req,res) => {
    console.log(req.body);
    const person = new Person({
        name: req.body.name,
        age: req.body.age
    });
    person.save()
        .then(data => {
            res.json(data);
        })
        .catch(err => {
            res.json({message:err});
        });
});

module.exports = router;
