package Processing;


import GUI.Skills;

public class LecturesSkills {

    Skills currentSkills;

    public String getSkillList(String userInput) {

        if (userInput.contains("Monday")) {
            return "Monday";
        }
        if (userInput.contains("Wednesday")) {
            return "Tuesday";
        }
        if (userInput.contains("Thursday")) {
            return "Wednesday";
        }
        if (userInput.contains("Friday")) {
            return "Friday";
        }
        if (userInput.contains("Saturday")) {
            return "Saturday";
        }

        if (userInput.contains("Sunday")) {
            System.out.println("No lesson on Saturday, take it easy ...");
            return "No lesson on Saturday, take it easy ...";
        }



    /*data = "<div class='sepiaFW-help-view' style='padding:20px;'>"
            + "<h2>Here is a list of commands you can try:</h3>"
            + "<br>"
            + "<h3>Weather</h3>"
            + "<ul>"
            + "<li>How is the weather tomorrow</li>"
            + "</ul>"
            + "<h3>Radio</h3>"
            + "<ul>"
            + "<li>Play radio sunshine live</li>"
            + "<li>Play a radio with songs of Metallica</li>"
            + "</ul>"
            + "<h3>News</h3>"
            + "<ul>"
            + "<li>I'd like to read some news</li>"
            + "</ul>"
            + "<h3>Navigation</h3>"
            + "<ul>"
            + "<li>How long does it take to get from London to Liverpool</li>"
            + "</ul>"
            + "<h3>Public local transport</h3>"
            + "<ul>"
            + "<li>Show me the way from Munich to Berlin by train</li>"
            + "</ul>"
            + "<h3>Timer/Alarms</h3>"
            + "<ul>"
            + "<li>Set an alarm for tomorrom morning 8 am</li>"
            + "<li>Set a timer for 15min</li>"
            + "<li>Show me my timers</li>"
            + "</ul>"
            + "<h3>Lists</h3>"
            + "<ul>"
            + "<li>Put pay bills on my to-do list</li>"
            + "<li>Put milk on my shopping-list</li>"
            + "<li>Create a new list</li>"
            + "<li>Show me my supermarket list</li>"
            + "</ul>"
            + "<h3>Soccer</h3>"
            + "<ul>"
            + "<li>When does Werder Bremen play</li>"
            + "<li>Show me Bundesliga results</li>"
            + "<li>Show me Bundesliga standing</li>"
            + "</ul>"
            + "<h3>Smart Home</h3>"
            + "<ul>"
            + "<li>Set the light in the living room to 70%</li>"
            + "<li>Lights off</li>"
            + "<li>Light status in the bath</li>"
            + "</ul>"
					*//*
					+ "<h3>Food delivery</h3>"
					+ "<ul>"
						+ "<li>I'd like to eat something</li>"
					+ "</ul>"
					+ "<h3>Shopping</h3>"
					+ "<ul>"
						+ "<li>I need new shoes</li>"
					+ "</ul>"
					*//*
            + "<h3>Web search</h3>"
            + "<ul>"
            + "<li>Google search for Bonobos</li>"
            + "<li>Search with Duck Duck Go for recipes of cheesecake</li>"
            + "<li>What is the stock price of apple?</li>"
            + "<li>Show me pictures of the most beautiful city on earth</li>"
            + "</ul>"
            + "</div>";
}

		return data;*/

    return null;}
}