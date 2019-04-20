package jr.discord.bot;

import jr.discord.bot.listener.GuildEventListener;
import net.dv8tion.jda.core.JDABuilder;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException {
        new JDABuilder("")
                .addEventListener(new GuildEventListener())
                .build();
    }
}
