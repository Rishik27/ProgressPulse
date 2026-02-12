const userId = 1; //Initial ID of user

async function addEvent() {
    const event = {
        eventName: document.getElementById("eventName").value,
        eventType: document.getElementById("eventType").value,
        startDate: document.getElementById("startDate").value,
        user: {id: userId}
    };
     await fetch("api/events", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"},
            body: JSON.stringify(event)
     });
     loadEvents();
}

async function loadEvents() {
    const response = await fetch("api/events/${userId}");
    const events = await response.json();

    const container = document.getElementById("events");
    container.innerHTML = "";

    events.forEach(event => {
        const today = new Date();
        const newstart = new Date(event.startDate);
        const difference = today - newstart;
        const days = Math.floor(difference / (1000 * 60 *60 *24));

        container.innerHTML += `<div>
            <h3>${event.eventName}</h3>
            <p>${days} Days Passed</p>
            <p>${event.eventType}</p>
            <p>${new Date(event.startDate).toLocaleDateString()}</p>
            </div>`;
    })
}

loadEvents();
setInterval(loadEvents, 1000);