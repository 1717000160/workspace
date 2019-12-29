package model.disk;

/**
 * @author BFELFISH 该类为文件类，包括了文件内容
 */
public class Files extends FileItem {
	// 文件内容
	private String content;

	public Files(Directory father, String fileName, String fileExtentionName, int capacity, int startNum,
			int attributes, String content) {
		super(father, fileName, fileExtentionName, capacity, startNum, attributes);
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 该方法是修改该内容
	 *
	 * @param 传入修改后的内容
	 * @return int:返回一个数字，0：修改成功，1：只读属性文件不可修改，2：磁盘空间不足
	 */
	public int changeFilesContent(String content) {
		int errorCode = 0;
		while (true) {
			if (this.attributes == 0) {
				errorCode = 1;
				break;
			}
			int numberOfBlocks;
			int capacities;
			int numberOfUsedBlocks = this.capacity/ Disk.getInstance().CAPACITY_OF_DISK_BLOCKS + 1;
			// 计算这个文件占用多少个磁盘块,如果是可执行文件，一行一字节
			if (this.fileExtentionName.equals(".txt")) {
				 capacities = content.getBytes().length;
				numberOfBlocks = capacities / Disk.getInstance().CAPACITY_OF_DISK_BLOCKS + 1;
			} else {
				String[] contents = content.split("\n");
				 capacities = contents.length;
				numberOfBlocks = capacities / Disk.getInstance().CAPACITY_OF_DISK_BLOCKS + 1;
			}
			if (numberOfBlocks > FAT.getInstance().capacityOfDisk()+numberOfUsedBlocks) {
				errorCode = 2;
				break;
			}else {
				//减少了磁盘块的占用
				if(numberOfUsedBlocks>numberOfBlocks) {
					FAT.getInstance().remove(this.startNum,numberOfUsedBlocks, numberOfBlocks);
				}else if(numberOfUsedBlocks<numberOfBlocks) {
					FAT.getInstance().Append(this.startNum, numberOfBlocks-numberOfUsedBlocks);
				}
				this.capacity=capacities;
				this.content = content;
				
			}		
			break;
		}
		
		return errorCode;
	}

	@Override
	/**
	 * 删除文件
	 */
	public boolean deleteFiles() {
		boolean succeed = true;
		if (this.canBeDeleted) {
			fatherFile.removeFiles(this);
			FAT.getInstance().recovery(this.startNum);
		} else {
			succeed = false;
		}
		return succeed;
	}

	@Override
	public boolean changeAttributes(int attributes) {
		boolean succeed = true;
		this.attributes = attributes;
		return succeed;

	}

	public boolean isTxtFile() {
		if (fileExtentionName.equals(".txt")) {
			return true;
		}
		return false;
	}
}
