const userId = 1;

async function addEvent() {

    const name = document.getElementById("eventName").value;
    const type = document.getElementById("eventType").value;
    const startDate = document.getElementById("startDate").value;

    if (!name || !startDate) {
        alert("Please fill all the required fields");
        return;
    }

    const event = {
        name: name,
        type: type,
        date: startDate
    };

    await fetch("/events", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(event)
    });

    alert("Event Added Successfully!");
    loadEvents();
}
async function deleteEvent(){
    const name = document.getElementById("EventName").value;
    const type = document.getElementById("EventType").value;
    const startDate = document.getElementById("StartDate").value;
    if (!name) {
        alert("Please enter the event name to delete");
        return;
    }

    await fetch(`/events/${name}`, {
        method: "DELETE"
    });

    alert("Event Deleted Successfully!");
    loadEvents();
}
async function loadEvents() {

    const response = await fetch("/events");
    const events = await response.json();

    const table = document.getElementById("eventTable");
    table.innerHTML = "";

    events.forEach(e => {
        table.innerHTML += `
            <tr>
                <td>${e.name}</td>
                <td>${e.type}</td>
                <td>${e.date}</td>
            </tr>
        `;
    });
}

window.onload = loadEvents;

