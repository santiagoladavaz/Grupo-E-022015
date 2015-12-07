package services.interfaces;



import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import model.Player;
import services.rest.request.PlayerRequest;
import services.rest.response.PlayerResponse;

public interface PlayerService {

	@Transactional
	public void savePlayer(Player pl);

	public List<Player> getAll();

	public List<PlayerResponse> toResponse(List<Player> all);
	
	@Transactional
	public void editPlayerByRequest(PlayerRequest request);
	@Transactional
	public PlayerResponse createPlayerByRequest(PlayerRequest request);
	
	public Player searchPlayerByName(String name);
}
