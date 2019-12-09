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

// Get specific post

router.get('/:postId', (req,res) => {
    try {
        const post = Post.findByID(req.params.postId);
        res.json(post);
    } catch (e) {
        res.json({message:err});
    }
})

// Delete specific post
router.get('/:postId', (req,res) => {
    // Here I am comparing the parameter _id in the mongodb to the value that is input in the url and if they match, remove it.
    // The ':' sign matches
    Post.remove({_id: 'req.params.postId'})
})

module.exports = router;
