package jr.discord.bot.command;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import org.springframework.stereotype.Component;


public interface Command {

  String getCommand();

  void execute(MessageChannel channel, User author, Message message);

}
