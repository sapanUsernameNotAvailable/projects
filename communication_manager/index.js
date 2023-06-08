const express = require('express')
const app = express()

const dirTree = require("directory-tree");
const fs = require('fs');
const exec = require('child_process').exec;

const Lib = require("./lib");

let memData = {}
const loginData = {}

app.use(express.json());

app.get('/traverse', (req, res) => {
    let path = req.query.path;
    const tree = dirTree(`${path}`, {depth:1});
    res.send(tree)
})

app.get('/display', (req, res) => {
    let path = req.query.path;
    if (!path.includes('passwd')
        && !path.includes('shadow')
        && !path.includes('appDiskStorage')) {
            let binary = fs.readFileSync(`${path}`);
            res.send(binary);
    }
})

app.get('/processes', (req, res) => {
    exec('ps aux',
        function(error, stdout, stderr){
            res.send(stdout);
        });
})

app.get('/register', (req, res) => {
    let name = req.query.name;
    let pwd = req.query.pwd;
    memData['credentials'][name] = pwd;
    res.send('OK.')
    Lib.persist(memData);
})

app.get('/login', (req, res) => {
    let name = req.query.name;
    let pwd = req.query.pwd;
    if (memData['credentials'][name] == pwd) {
        const { v4: uuidV4 } = require('uuid');
        let token = uuidV4();
        loginData[name] = token
        res.send(token)
    } else {
        res.send('Denied.')
    }
})

app.post('/message', (req, res) => {
    let to = req.query.to;
    let message = req.body

    let messages = memData['messages'][to]
    if (!messages) {
        messages=[]
    }
    messages.push(message.content)
    memData['messages'][to] = messages
    Lib.persist(memData);
    res.send('Ok')
})

app.get('/messages', (req, res) => {
    let user = req.query.user;
    let token = req.query.token;
    if (loginData[user] == token) {
        res.send(memData['messages'][user])
    } else {
        res.send('Denied.')
    }
})

app.listen(3000, () => {
    memData = Lib.read()
    console.log(`App listening.`)
})