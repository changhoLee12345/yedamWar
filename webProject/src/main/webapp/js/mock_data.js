/**
 * mock_data.js
 */
const json = `
[{"id":1,"first_name":"Louie","last_name":"Angus","email":"langus0@columbia.edu","gender":"Male","salary":4263},
{"id":2,"first_name":"Kimberli","last_name":"Fidge","email":"kfidge1@disqus.com","gender":"Female","salary":2246},
{"id":3,"first_name":"Xenia","last_name":"Snoday","email":"xsnoday2@themeforest.net","gender":"Female","salary":2346},
{"id":4,"first_name":"Arvin","last_name":"Watsam","email":"awatsam3@mashable.com","gender":"Male","salary":4000},
{"id":5,"first_name":"Stavros","last_name":"Dobbing","email":"sdobbing4@wix.com","gender":"Male","salary":3058},
{"id":6,"first_name":"Hieronymus","last_name":"Edgerton","email":"hedgerton5@cafepress.com","gender":"Male","salary":1306},
{"id":7,"first_name":"Arv","last_name":"Skiplorne","email":"askiplorne6@sun.com","gender":"Male","salary":3294},
{"id":8,"first_name":"Bernie","last_name":"Munn","email":"bmunn7@thetimes.co.uk","gender":"Male","salary":3406},
{"id":9,"first_name":"Tomas","last_name":"Midgely","email":"tmidgely8@friendfeed.com","gender":"Male","salary":1398},
{"id":10,"first_name":"Klement","last_name":"Hanselmann","email":"khanselmann9@google.ru","gender":"Male","salary":2239},
{"id":11,"first_name":"Dolf","last_name":"Moverley","email":"dmoverleya@ucoz.ru","gender":"Male","salary":4441},
{"id":12,"first_name":"Leupold","last_name":"Dunridge","email":"ldunridgeb@virginia.edu","gender":"Male","salary":1524},
{"id":13,"first_name":"Killie","last_name":"Beacon","email":"kbeaconc@marriott.com","gender":"Male","salary":3701},
{"id":14,"first_name":"Augustine","last_name":"McConachie","email":"amcconachied@homestead.com","gender":"Female","salary":3077},
{"id":15,"first_name":"Laverna","last_name":"Stores","email":"lstorese@geocities.jp","gender":"Genderfluid","salary":3709},
{"id":16,"first_name":"Hannah","last_name":"Hackelton","email":"hhackeltonf@toplist.cz","gender":"Female","salary":2878},
{"id":17,"first_name":"Marcellus","last_name":"Dunbobin","email":"mdunbobing@abc.net.au","gender":"Male","salary":1070},
{"id":18,"first_name":"Annelise","last_name":"Looks","email":"alooksh@cnn.com","gender":"Female","salary":4845},
{"id":19,"first_name":"Fabio","last_name":"Maker","email":"fmakeri@privacy.gov.au","gender":"Male","salary":2105},
{"id":20,"first_name":"Meaghan","last_name":"Heaney","email":"mheaneyj@nymag.com","gender":"Female","salary":1138}]
`;

const members = JSON.parse(json); // 문자열 => 객체 변환.
console.log(members);

