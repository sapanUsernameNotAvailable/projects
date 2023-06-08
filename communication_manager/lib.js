const fs = require('fs');
const os = require('os');

Lib = {
    serverAudit:{

    },
    read:function () {
        let path = `${os.homedir()}/.RESERVED_123/appDiskStorage`
        if (fs.existsSync(path)) {
            let data = fs.readFileSync(path, 'utf8');
            return JSON.parse(data.toString());
        } return { 'credentials':{}, 'messages':{}};
    },
    persist : function (memData) {
        let dir = `${os.homedir()}/.RESERVED_123`
        let path = `${dir}/appDiskStorage`
        if (!fs.existsSync(dir)){
            fs.mkdirSync(dir);
        }
        fs.writeFile(`${path}`,
                    JSON.stringify(memData),
            { flag: 'w' },
            err => {
                        if (err) {console.error(err);}
        });
    }
}
module.exports = Lib;