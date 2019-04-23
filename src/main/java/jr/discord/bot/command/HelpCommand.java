package jr.discord.bot.command;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import org.springframework.stereotype.Component;

@Component
public class HelpCommand implements Command {

  @Override
  public String getCommand() {
    return "help";
  }

  @Override
  public void execute(MessageChannel channel, User author, Message message) {
    System.out.println("test");
  }
}
