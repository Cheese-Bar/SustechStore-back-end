function onClickTest(){
    let formData = new FormData();
    formData.append("id", 1)
    // formData.append(pageNum, 0)
    // formData.append(pageSize, 5)
    // formData.append("district", district)
    // formData.append("earliest_check_in_time", earliest_check_in_time)
    // formData.append("price", price)
    // formData.append("room_type", room_type)
    console.log(formData.get("id"))
    let xhr = new XMLHttpRequest();
    xhr.open("GET", "/order/byBuyer",false);
    xhr.send(formData);
    xhr.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            // window.location.href="hotel.html"
            alert("Success")
        }
    }
}