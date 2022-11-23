/*
 * Ajax get, post, patch, delete 구현
 */
export const ajax = {
	get(url) {
		return fetch(url);
	},
	post(url, payload) {
		return fetch(url, {
			method: 'POST',
			headers: {
				'content-Type': 'application/x-www-form-urlencoded'
			},
			body: payload
		});
	},
	patch(url, payload) {
		return fetch(url, {
			method: 'PATCH',
			headers: {
				'content-Type': 'application/json'
			},
			body: JSON.stringify(payload)
		});
	},
	delete(url) {
		return fetch(url, {
			method: 'DELETE'
		})
	}
};

/*
 *	LocalDateTime 변환
 *	LocalDateTime을 yyyy-mm-dd hh:mm:ss형식으로 보여주기
 */
export function timestamp(date) {
	let fomatData = new Date(date);
	console.log(fomatData.getTimezoneOffset());
	fomatData = new Date(fomatData.getTime() - (fomatData.getTimezoneOffset() * 60000));
	return fomatData.toISOString().replace('T', ' ').slice(0, 19);
}
/*
 *  LocalDateTime을 yyyy-mm-dd 형식으로 보여주기
 */
export function timedate(date) {
	let fomatData = new Date(date);
	fomatData = new Date(fomatData.getTime() - (fomatData.getTimezoneOffset() * 60000));
	return fomatData.toISOString().slice(0, 10);
}

// 통화:세자리구분(23,000,000) 
export function korformat(num) {
	let translateArr = [];
	let numString = num.toString();
	let numAry = numString.split('');
	numAry.reverse();

	let divis = 3;
	for (let i = 0; i < numAry.length; i++) {
		if (i == divis) {
			translateArr.push(',');
			divis += 3;
		}
		translateArr.push(numAry[i])
	}
	return translateArr.reverse().join('');
}

export function deformat(numStr) {
	let numAry = numStr.split('');
	while (true) {
		let idx = 0;
		idx = numAry.indexOf(',', idx);
		if (idx < 0)
			break;
		numAry.splice(idx, 1);
	}
	return numAry.join('');
}