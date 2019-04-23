package jr.discord.bot;

import jr.discord.bot.listener.GuildEventListener;
import net.dv8tion.jda.core.JDABuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BotApplication implements CommandLineRunner {
//todo add list of listeners
  private GuildEventListener guildEventListener;

  public BotApplication(GuildEventListener guildEventListener) {
    this.guildEventListener = guildEventListener;
  }

  public static void main(String[] args) {
    SpringApplication.run(BotApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    new JDABuilder("")
        .addEventListener(guildEventListener)
        .build();
  }
}
