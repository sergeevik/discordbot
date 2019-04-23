package jr.discord.bot.command;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandHandler {

  private Map<String, Command> commandMap;

  @Autowired
  public CommandHandler(List<Command> commands) {
    commandMap = commands.stream()
        .collect(Collectors.toMap(Command::getCommand, Function.identity()));
  }

  public void process(MessageChannel channel, User author, Message message) {
//todo some performing
    Command command = commandMap.get("");
    command.execute(channel, author, message);
  }

  public boolean isCommand(Message message) {
    //todo
    if (!message.getContentRaw().isEmpty()) {
      return true;
    }
    return false;
  }
}
