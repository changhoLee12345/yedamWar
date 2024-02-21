/**
 * 댓글관련 함수..
 */

console.log('start boardService.js');

const targetUl = document.querySelector('div.content>ul');

fetch('replyList.do?bno=256&rpage=2')
    .then(resolve => resolve.json())
    .then(result => {
        boardList(result);
    })
    .catch(err => console.log(err));

// 목록출력하는 콜백함수.
const boardList = function (boardAry = []) {
    boardAry.forEach(board => {
        let template = document.querySelector('div.content>ul>li:nth-of-type(3)').cloneNode(true);
        template.style.display = 'block';
        template.querySelector('span:nth-of-type(1)').textContent = board.replyNo;
        template.querySelector('span:nth-of-type(2)').textContent = board.reply;
        template.querySelector('span:nth-of-type(3)').textContent = board.replyer;
        targetUl.appendChild(template);
    })
}