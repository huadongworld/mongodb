
# mongo基础操作指令

use mini_program;

show dbs;

db;

db.mini_program.insert({"name":"小程序"});

db.dropDatabase;

show tables;

show collections;

db.mini_program.drop();

db.createCollection("mini_program");

db.mini.insert({title:"小程序",desc:"超级车联小程序"});

db.mini.find();

db.mini.update({"title":"--小程序--"},{$set:{"title":"-小程序-"}},{multi:true});

db.mini.find().pretty();

db.mini.find({likes: {$gte : 100}}); // >:$gt; >=:$gte; <:$lt; <=:$lte;

db.mini.find({likes : {$lt :200, $gt : 100}});

db.mini.deleteMany({});

db.mini.find({"title" : {$type : 'string'}});

db.mini.find().limit(2).skip(1).pretty();

db.mini.find().sort({likes:1}).pretty();

