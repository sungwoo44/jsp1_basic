const category = document.querySelector('select[name="category"]')
const keyword = document.querySelector('input[name="keyword"]')
const from = document.querySelector('input[name="from"]')
const to = document.querySelector('input[name="to"]')


console.log(temp)
// 카테고리 조회 했을 때만 temp 가 null 
// 완전 초기화면만 / 다른 컬럼(가격,상품명으로만 검색 한 경우) null 
if(temp != null)category.value=temp

document.getElementById('search').addEventListener('click', () => {
	let isValid = true
	if (keyword.value.length == 0 && category.value.length == 0
		&& from.value.length == 0 && to.value.length == 0) {
		isValid = false
		alert('검색어를 입력하세요.')
	}

	if (isValid)
		document.forms[0].submit();
})