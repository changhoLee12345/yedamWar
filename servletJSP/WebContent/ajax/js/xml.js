/**
 * 
 */

document.addEventListener('DOMContentLoaded', xmlCreate);

async function xmlCreate() {

    let doc;
    await fetch('./js/cd_catalog.xml')
        .then(result => result.text())
        .then(result => {
            const xmlStr = result;
            const parser = new DOMParser();
            doc = parser.parseFromString(xmlStr, "application/xml");
            // print the name of the root element or error message
            // const errorNode = doc.querySelector("parsererror");
            // if (errorNode) {
            //     console.log("error while parsing");
            // } else {
            //     console.log(doc.documentElement.nodeName);
            // }

        })
        .catch(error => console.log(error))

    console.log(doc);

    // tbody생성.    
    let tbody = document.createElement('tbody');
    let cdAry = doc.getElementsByTagName('CD')

    for (let cd of cdAry) {
        let tr = document.createElement('tr');
        let items = cd.children;
        for (let prop of items) {
            //console.log(prop.nodeName, prop.textContent)
            let td = document.createElement('td');
            td.innerText = prop.textContent;
            tr.append(td);
        }
        tbody.append(tr);
        //console.log(cd.children[0].textContent, cd.firstElementChild.textContent, cd.firstElementChild.nodeName)
        // let li = document.createElement('li');
        // let txt = document.createTextNode('title:' + cd.firstElementChild.textContent)
        // li.append(txt);
        // ul.append(li);
    }

    // thead생성.    
    let thead = document.createElement('thead');
    let tr = document.createElement('tr');
    thead.append(tr);

    let titles = doc.getElementsByTagName('CD')[0].children;
    for (let title of titles) {
        let th = document.createElement('th');
        th.innerText = title.nodeName;
        tr.append(th)
    }

    let table = document.createElement('table');
    table.append(thead);
    table.append(tbody);
    document.getElementById('show').append(table);

}