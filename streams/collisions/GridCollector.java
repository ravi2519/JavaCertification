package streams.collisions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.IntStream;

public class GridCollector {
	// the product of this collector
	private List<List<Box>> cells;
	// grid size
	private GridSpec spec;
	
	
	private GridCollector(GridSpec gridSpec) {
		spec = gridSpec;
		
		cells = new ArrayList<>(spec.rows * spec.cols);
		// initialize with empty lists
		IntStream.range(0, spec.rows * spec.cols)
			     .forEach(i -> cells.add(new ArrayList<>()));
	}
	
	// Process the next box
	public void update(Box b) {
		int row1 = b.y1 / spec.rowHeight, col1 = b.x1 / spec.colWidth,
			row2 = b.y2 / spec.rowHeight, col2 = b.x2 / spec.colWidth;
		// add the box to all impacted cells
		for (int row=row1; row<=row2; row++)
			for (int col=col1; col<=col2; col++)
		         cells.get(row * spec.cols + col).add(b);
	}
	
	
	// Merge this collector with another one	
	public GridCollector merge(GridCollector other) {
		// cell-wise merge
		IntStream.range(0, cells.size())
		         .forEach(i -> cells.get(i).addAll(other.cells.get(i)));
		return this;
	}
	
	
	// Extracts the result of this collector
	public List<List<Box>> finish() {
		return cells;
	}
	
	
	// Factory method
	public static Collector<Box, ?, List<List<Box>>> of(GridSpec gridSpec) {
		
		return Collector.<Box, GridCollector, List<List<Box>>>of(
				() -> new GridCollector(gridSpec), // supplier of initial summary
				GridCollector::update,             // accumulator
				GridCollector::merge,              // combiner
				GridCollector::finish,             // finisher
				Collector.Characteristics.UNORDERED);
	}
}
