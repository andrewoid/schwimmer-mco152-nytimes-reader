package schwimmer.nytimes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NYTimesService {
	
	@GET("/svc/topstories/v2/science.json?api-key=53bc39c612e74b2ba1ea2903203b9eb9")
	Call<StoriesModel> getTopStories();

}
